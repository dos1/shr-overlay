# The Boost web site provides free peer-reviewed portable
# C++ source libraries. The emphasis is on libraries which
# work well with the C++ Standard Library. The libraries are
# intended to be widely useful, and are in regular use by
# thousands of programmers across a broad spectrum of applications.

DESCRIPTION = "Free peer-reviewed portable C++ source libraries"
HOMEPAGE = "http://www.boost.org/"
SECTION = "libs"
DEPENDS = "boost-jam-native-3.1.17 zlib"
PRIORITY = "optional"
LICENSE = "Boost Software License"

ARM_INSTRUCTION_SET = "arm"
BOOST_VER = "${@"_".join(bb.data.getVar("PV",d,1).split("."))}"
BOOST_MAJ = "${@"_".join(bb.data.getVar("PV",d,1).split(".")[0:2])}"
BOOST_P = "boost_${BOOST_VER}"

# You cen get a list of all the libs by (including quite some false positives):
# find $BOOST_ROOT/libs -iname jamfile\* -exec grep '^lib boost_' {} \; | awk '{gsub("boost_","",$2);print $2;}'
# I didn't find any other way (like investigating the Jamroot file) to list them. Pity.
# False positives include: math_* is just math, there are no regex_extra,
# wserialization, prg_exec_monitor, test_exec_monitor, unit_test_framework
# MPI seems to have some extra treatment.
# math seems to break in SHR (openmoko)
BOOST_LIBS ?= "\
	date_time \
	filesystem \
	graph \
	iostreams \
#	math \
	program_options \
	regex \
	serialization \
	signals \
	system \
	thread \
	wave \
	"

#BJAM_PYTHON = ""
# To enable python, uncomment the following:
#BOOST_LIBS += "python"
#DEPENDS += "python"
#PYTHON_ROOT = "${STAGING_DIR_HOST}/${layout_prefix}"
#PYTHON_VERSION = "2.5"
#BJAM_PYTHON += "-sPYTHON_VERSION=${PYTHON_VERSION} --with-python-root=${PYTHON_ROOT}"

S = "${WORKDIR}/${BOOST_P}"

# Make a package for each library, plus -dev
PACKAGES = "${PN}-dbg ${BOOST_PACKAGES}"
python __anonymous () {
    import bb

    packages = []
    extras = [] 
    for lib in bb.data.getVar('BOOST_LIBS', d, 1).split( ):
        pkg = "boost-%s" % lib.replace("_", "-")
        extras.append("--with-%s" % lib)
        packages.append(pkg)
        if not bb.data.getVar("FILES_%s" % pkg, d, 1):
            bb.data.setVar("FILES_%s" % pkg, "${libdir}/libboost_%s*.so*" % lib, d)
    bb.data.setVar("BOOST_PACKAGES", " ".join(packages), d)
    bb.data.setVar("BJAM_EXTRA", " ".join(extras), d)
}

# Override the contents of specific packages
FILES_boost-serialization = "${libdir}/libboost_serialization*.so* \
	${libdir}/libboost_wserialization*.so*"
FILES_boost-test = "${libdir}/libboost_prg_exec_monitor*.so \
	${libdir}/libboost_unit_test_framework*.so*"

# -dev last to pick up the remaining stuff
PACKAGES += "${PN}-dev"
FILES_${PN}-dev = "${includedir} ${libdir}/libboost_*.so ${libdir}/libboost_*.a"

# "boost" is a metapackage which pulls in all boost librabries
PACKAGES += "${PN}"
RRECOMMENDS_${PN} += "${BOOST_PACKAGES}"

# to avoid GNU_HASH QA errors added LDFLAGS to ARCH; a little bit dirty but at least it works
TARGET_CC_ARCH += " ${LDFLAGS}" 

# Quotation marks, there might be an easier way to do this, but I can't find
# it.  The problem is that the user.hpp configuration file must receive a
# pre-processor macro defined as the appropriate string - complete with "'s
# around it.  (<> is a possibility here but the danger to that is that the
# failure case interprets the < and > as shell redirections, creating
# random files in the source tree.)
#
#bjam: '-DBOOST_PLATFORM_CONFIG=\"config\"'
#do_compile: '-sGCC=... '"'-DBOOST_PLATFORM_CONFIG=\"config\"'"
SQD = '"'
EQD = '\"'
#boost.bb:   "...  '-sGCC=... '${SQD}'-DBOOST_PLATFORM_CONFIG=${EQD}config${EQD}'${SQD} ..."
BJAM_CONF = "${SQD}'-DBOOST_PLATFORM_CONFIG=${EQD}boost/config/platform/${TARGET_OS}.hpp${EQD}'${SQD}"

# bzip2 and zip are disabled because... they're broken - the compilation simply
# isn't working with bjam.  I guess they will fix it, but who needs it?  This
# only affects the (new in 33) iostream library.
BJAM_TOOLS   = "-sTOOLS=gcc \
		'-sGCC=${CC} '${BJAM_CONF} \
		'-sGXX=${CXX} '${BJAM_CONF} \
		'-sGCC_INCLUDE_DIRECTORY=${STAGING_INCDIR}' \
		'-sGCC_STDLIB_DIRECTORY=${STAGING_LIBDIR}' \
		'-sNO_BZIP2=1' \
		'-sNO_ZLIB=1' \
		'-sBUILD=release <optimization>space <inlining>on <debug-symbols>off' \
		'--layout=system' \
		"

BJAM_OPTS    = '${BJAM_TOOLS} ${BJAM_PYTHON} \
		--builddir=${S}/${TARGET_SYS} \
		${BJAM_EXTRA}'

do_configure_prepend() {
	cp -f boost/config/platform/linux.hpp boost/config/platform/linux-gnueabi.hpp

	echo 'using gcc : 4.3.1 : ${CXX} : compileflags -DBOOST_SP_USE_PTHREADS -I${includedir} linkflags -L${libdir} ;' >> ${S}/tools/build/v2/user-config.jam
}

do_compile() {
	set -ex
	bjam ${BJAM_OPTS} --prefix=${prefix} \
		--exec-prefix=${exec_prefix} \
		--libdir=${libdir} \
		--includedir=${includedir}
}

do_stage() {
	set -ex
	bjam ${BJAM_OPTS} \
		--libdir=${STAGING_LIBDIR} \
		--includedir=${STAGING_INCDIR} \
		install
}

do_install() {
	set -ex
	bjam ${BJAM_OPTS} \
		--libdir=${D}${libdir} \
		--includedir=${D}${includedir} \
		install
}

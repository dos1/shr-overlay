DESCRIPTION = "Python DES implementation"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python"

PR = "r1"
ARCH_pydes = "all"

SRC_URI = "http://twhiteman.netfirms.com/pyDES/pyDes-1.3.1.tar.gz"

inherit autotools

S = ${WORKDIR}

do_install() {
        install -d ${D}/usr/lib/python2.5/site-packages
        install -m 0755 ${S}/pyDes-1.3.1/pyDes.py ${D}/usr/lib/python2.5/site-packages
}

do_configure() {
        exit 0
}

do_compile() {
        exit 0
}

FILES_${PN} += "/usr/lib/python2.5/site-packages/*"


DESCRIPTION = "OpenMooCow makes your phone (nearly) become a cow!"
HOMEPAGE = "http://www.srcf.ucam.org/~taw27/openmoko/openmoocow/"
AUTHOR = "Thomas White"
LICENSE = "GPLv3"
SECTION = "applications/games"
PV = "0.0.3"
PR = "r0"

SRC_URI = "git://www.srcf.ucam.org/~taw27/openmoko/openmoocow/openmoocow.git;protocol=http;rev=HEAD \
file://openmoocow.desktop"
S = "${WORKDIR}/git"
inherit autotools

do_install_append() {
	install -d ${D}/${datadir}/applications
	install -m 0644 ../openmoocow.desktop ${D}/${datadir}/applications
}

FILES_${PN} += "\
  ${datadir}/applications/openmoocow.desktop"



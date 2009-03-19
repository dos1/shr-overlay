DESCRIPTION = "elementary and EFL bindings for the vala programming language"
HOMEPAGE = "http://git.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mickey@vanille-media.de> et al. (see AUTHORS)"
LICENSE  = "GPL2+"
DEPENDS = "vala elementary"
#SECTION = "x11/application"
PV = "0.0.1+r${SRCREV}"
PR = "r1"


SRC_URI = "${FREESMARTPHONE_GIT}/libeflvala.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools

#do_install(){
#        install -d ${D}${datadir}/applications
#        install -m 0644 ${S}/data/elementary-calculator.desktop ${D}${datadir}/applications/
#        install -d ${D}${datadir}/pixmaps
#        install -m 0644 ${S}/data/calculator.png ${D}${datadir}/pixmaps/
#        install -d ${D}${bindir}
#        install -m 0744 ${S}/calc ${D}${bindir}/
#}
#
#FILES_${PN} += "${prefix}/share/pixmaps"
#FILES_${PN} += "${prefix}/share/applications"

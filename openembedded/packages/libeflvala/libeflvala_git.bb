DESCRIPTION = "elementary and EFL bindings for the vala programming language"
HOMEPAGE = "http://git.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mickey@vanille-media.de> et al. (see AUTHORS)"
LICENSE  = "GPL2+"
DEPENDS = "vala elementary"
#SECTION = "x11/application"
PV = "0.0.1+r${SRCREV}"
PR = "r2"


SRC_URI = "${FREESMARTPHONE_GIT}/libeflvala.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

#don't need examples for building vala programs
EXTRA_OECONF = "--disable-examples"

inherit autotools

do_configure() {
    ./autogen.sh
    autotools_do_configure
}
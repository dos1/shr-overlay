DESCRIPTION = ""
SECTION = "libs"
PV = "0.0.1+gitr${SRCREV}"
PR = "r0"

inherit autotools pkgconfig

DEPENDS = "vala-native gobject-introspection"

SRC_URI = "git://shr.bearstech.com/repo/libmodulo.git;protocol=http;branch=master"
S = "${WORKDIR}/git"


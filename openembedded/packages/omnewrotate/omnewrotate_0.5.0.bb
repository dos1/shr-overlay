DESCRIPTION = "OpenMoko New Rotate is a screen rotation program"
HOMEPAGE = "http://code.google.com/p/omnewrotate/"
AUTHOR = "Rui Seabra"
LICENSE = "GPLv3"
SECTION = "console/network"
DEPENDS = "libframeworkd-glib xrandr"
PV = "0.5.0"
PR = "r0"

SRC_URI = "svn://omnewrotate.googlecode.com/svn/trunk;module=.;proto=http;rev=HEAD"
S = "${WORKDIR}"

inherit autotools

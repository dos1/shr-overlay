DESCRIPTION = "intone is a mplayer frontend for openmoko phones"
HOMEPAGE = "http://code.google.com/p/intone/"
AUTHORE = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "elementary eina sqlite3 edbus"
RDEPENDS = "mplayer lame libxv libsdl-x11"

PV = "0.0.1+svnr${SRCREV}"
SRC_URI = "svn://intone.googlecode.com/svn/trunk;module=.;proto=http"
S = "${WORKDIR}"

inherit autotools


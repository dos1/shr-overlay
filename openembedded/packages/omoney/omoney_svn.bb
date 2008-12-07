DESCRIPTION = "OMoney is a bookkeeping application for Openmoko"
HOMEPAGE = "http://omoney.googlecode.com"
AUTHOR = "Bumbl"
LICENSE = "GPLv2"
SECTION = "openmoko/money"
RDEPENDS_${PN} = "python python-datetime python-evas python-edje python-ecore python-etk python-sqlite3"
PV = "milestone1-${SRCREV}"
PR = "r0"
SRC_URI = "svn://omoney.googlecode.com/svn/trunk;module=.;proto=http;rev=28"
S = "${WORKDIR}"
inherit distutils
FILES_${PN} = "/usr/bin/omoney /usr/share/omoney/omgui.edj /usr/share/pixmaps/omoney.png /usr/share/applications/omoney.desktop"


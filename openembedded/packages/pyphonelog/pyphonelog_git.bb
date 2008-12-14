DESCRIPTION = "PyPhonelog is a phonelog gui that connects to the shr daemon/a custom daemon"
HOMEPAGE = "http://wiki.openmoko.org/wiki/PyPhonelog"
SECTION = "x11/applications"
LICENSE = "GPLv2"
SRCNAME = "pyphonelog"
DEPENDS += "python python-pygtk python-setuptools"
#python-sqlite3"

inherit distutils

S = "${WORKDIR}/git"
PV = "0.15.1"
PR = "r0"
SRC_URI = "git://shr.bearstech.com/repo/pyphonelog.git;protocol=http"
FILES_${PN} += "${datadir}/applications/phonelog.desktop ${datadir}/phonelog/"

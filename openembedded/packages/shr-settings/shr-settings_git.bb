DESCRIPTION = "Modular settings application for SHR based on python-elementary"
HOMEPAGE = "http://shr-project.org"
SHR_RELEASE ?= "shr"
LICENSE ?= "GPL"
RDEPENDS = "python-elementary python-dbus python-codecs python-shell python-pyrtc python python-edbus dbus-x11"
SECTION = "x11/application"
PV = "0.1.0+r${SRCREV}"
PR = "r3"

inherit setuptools

SRC_URI = "git://shr.bearstech.com/repo/shr-settings.git;protocol=http;branch=master"
S = "${WORKDIR}/git"
FILES_${PN} += "${prefix}/share/pixmaps"
FILES_${PN} += "${prefix}/share/applications"

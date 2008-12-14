DESCRIPTION = "Settings application based on om-settings"
DEPENDS = "python-etk python-edbus"
RDEPENDS = "python-etk python-re python-codecs python-edbus python-pyxdg dbus-x11"
SECTION = "x11/application"
SHR_PV = "0.0.1"
PR = "r2"

inherit shr setuptools
FILES_${PN} += "${prefix}/share/* ${sysconfdir}/X11/Xsession.d/*"


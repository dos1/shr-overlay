DESCRIPTION = "The SHR Contacts application"
SECTION = "x11/applications"
DEPENDS += "dbus-glib libframeworkd-glib libframeworkd-phonegui"
PV = "0.0.1"
PR = "r5"

inherit shr pkgconfig autotools

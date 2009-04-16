DESCRIPTION = "The Openmoko Messages"
SECTION = "x11/applications"
DEPENDS += "dbus-glib libframeworkd-glib libframeworkd-phonegui"
SHR_PV = "0.0.1"
PR = "r7"

inherit shr pkgconfig autotools

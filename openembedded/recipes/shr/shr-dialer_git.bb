DESCRIPTION = "The Openmoko Dialer"
SECTION = "x11/applications"
DEPENDS += "dbus-glib libframeworkd-glib libframeworkd-phonegui"
SHR_PV = "0.0.1"
PR = "r8"

inherit shr pkgconfig autotools

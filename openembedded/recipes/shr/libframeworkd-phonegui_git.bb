DESCRIPTION = "Frameworkd phonegui library"
SECTION = "libs"
PV = "0.0.2+gitr${SRCPV}"
PR = "r8"

inherit shr pkgconfig autotools autotools_stage

CONFFILES_${PN} = "${sysconfdir}/frameworkd-phonegui.conf"

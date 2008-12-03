DESCRIPTION = "The Openmoko Dialer"
DEPENDS += "matchbox-panel-2 libmokopanelui2 libframeworkd-glib libnotify"
SHR_PV = "0.0.1"
PR = "r8"

inherit shr autotools pkgconfig

FILES_${PN} = "${libdir}/matchbox-panel/lib*.so* ${datadir}"


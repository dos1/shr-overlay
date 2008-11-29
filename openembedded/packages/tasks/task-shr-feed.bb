DESCRIPTION = "SHR Feed"
PR = "r6"
PV = "1.0"
LICENSE = "GPL"

inherit task

RRECOMMENDS_${PN} += "\
		python-elementary \
		navit \
		openmoko-agpsui \
		mc \
		mplayer \
		x11vnc \
		omview \
		openvpn \
		navit \
		pythm \
		fbreader \
		dillo \"

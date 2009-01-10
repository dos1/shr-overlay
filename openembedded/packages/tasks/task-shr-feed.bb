DESCRIPTION = "SHR Feed"
PR = "r8"
PV = "1.0"
LICENSE = "GPL"

inherit task

RRECOMMENDS_${PN} += "\
		python-elementary \
		openmoko-agpsui \
		mc \
		mplayer \
		x11vnc \
		omview \
		openvpn \
		navit \
		pythm \
		fbreader \
		dillo \
		omoney \
		enotes \
		epdfview \
		pyphonelog \
		pingus \
		openmoocow \
		vagalume"

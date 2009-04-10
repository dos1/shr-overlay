DESCRIPTION = "SHR Feed"
PR = "r12"
PV = "1.0"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} += "\
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
		vagalume \
		python-pygame \
		mokoko \
		bluez-utils-alsa \
		obexpush \
		obexftp \
		gpe-calendar \
		fltk-chess \
		remoko \
		shr-config \
		openbmap-logger \
		ffalarms \
		libnotify \
		accelges \
		gpe-todo \
		ebrainy \
		sms-sentry \
		cellhunter \
		dillo2 \
		usbmode \
		zenity \
		pyefl-sudoku \
"

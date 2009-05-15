DESCRIPTION = "intone is a mplayer frontend for openmoko phones"
HOMEPAGE = "http://code.google.com/p/intone/"
AUTHORE = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "elementary eina sqlite3 edbus"
RDEPENDS = "mplayer lame libxv libsdl-x11"

PV = "0.0.1+svnr${SRCREV}"
PR = "r1"

SRC_URI = "svn://intone.googlecode.com/svn/trunk;module=.;proto=http \
file://small-large-defines.patch;patch=1;pnum=0 \
file://intone.png \
file://intone.desktop \
file://seek-fwd.png \
file://next.png \
file://no-album-art.jpg \
file://pause.png \
file://record.png \
file://user-home.png \
file://playlist.png \
file://folder.png \
file://prev.png \
file://seek-back.png \
file://song.png \
file://generic.png \
file://play.png \
file://album.png \
"
S = "${WORKDIR}"

inherit autotools

do_install_append() {
	mkdir -p "${D}/${datadir}/icons"
	install -m 0644 "${S}/intone.png" "${D}/${datadir}/icons"
	mkdir -p "${D}/${datadir}/applications"
	install -m 0644 "${S}/intone.desktop" "${D}/${datadir}/applications"
	mkdir -p "${D}/${datadir}/intone"
	install -m 0644 "${S}/seek-fwd.png" "${D}/${DATADIR}/intone"
	install -m 0644 "${S}/next.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/no-album-art.jpg" "${D}/${datadir}/intone"
	install -m 0644 "${S}/pause.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/record.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/user-home.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/playlist.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/folder.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/prev.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/seek-back.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/song.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/generic.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/play.png" "${D}/${datadir}/intone"
	install -m 0644 "${S}/album.png" "${D}/${datadir}/intone"
}


FILES_${PN} += "/usr/share/intone/* /usr/share/applications/* /usr/share/icons/*"


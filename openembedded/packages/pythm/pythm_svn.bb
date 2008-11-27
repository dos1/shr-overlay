DESCRIPTION = "Pythm is a media player gui designed to work with mplayer or mpd as "slave" players.\
use mplayer to hear music on the road or mpd control if your are at home."
HOMEPAGE = "http://projects.openmoko.org/projects/pythm/"
SECTION = "application/multimedia"
LICENSE = "GPLv2"
SRCNAME = "pythm"
PV = "0.5.1+svnr${SRCREV}"
SRC_URI = "svn://svn.projects.openmoko.org/svnroot/;module=pythm \
           file://pythm.desktop"
S = "${WORKDIR}/pythm"

inherit setuptools

RDEPENDS_${PN} = "\
  python-pygtk \
  mplayer \
"
DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --prefix=${prefix} \
    --install-data=${datadir}"

do_install_append() {
	install -d ${D}${sysconfdir}/mofi
	install -d ${D}/${datadir}/applications
	install -m 0644 ${S}/conf/pythm.conf-example ${D}${sysconfdir}/pythm.conf
        install -m 0644 ../pythm.desktop ${D}/${datadir}/applications
}


FILES_${PN} += "\
  ${sysconfdir}/pythm.conf \
  ${datadir}/applications/pythm.desktop"


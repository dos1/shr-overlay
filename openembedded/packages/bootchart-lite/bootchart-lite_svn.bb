DESCRIPTION = "Bootchart Lite for Embedded System."
AUTHOR = "Fred Chien"
LICENSE = "GPLv2"
HOMEPAGE = "http://code.google.com/p/bootchart-lite/"

SRCREV = 4
PV = "0.1+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://bootchart-lite.googlecode.com/svn/;module=trunk;rev=${SRCREV};proto=http"

S = "${WORKDIR}/trunk"

inherit autotools

pkg_postinst_${PN} () {
	mkdir -p /etc/bootchart-lite
}

pkg_postrm_${PN} () {
	rm -rf /etc/bootchart-lite
}


DESCRIPTION = "A dead simple calculator. It's advantage is that it's elementary-themed"
HOMEPAGE = "http://freehg.org/u/spaetz/calc"
AUTHOR = "Sebastian Spaeth <Sebastian@SSpaeth.de>"
SHR_RELEASE ?= "shr"
LICENSE  = "MIT"
RDEPENDS = "python-elementary python python-edbus"
SECTION = "x11/application"
PV = "0.0.1+r${SRCREV}"
PR = "r1"

#inherit setuptools

SRC_URI = "hg://http://freehg.org/u/spaetz/calc"
S = "${WORKDIR}"

do_install(){
        install -d ${D}${datadir}/applications
        install -m 0644 ${WORKDIR}/data/elementary-calculator.desktop ${D}${datadir}/applications/
        install -d ${D}${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/data/calculator.png ${D}${datadir}/pixmaps/
        install -m 0744 ${WORKDIR}/calc ${D}${bindir}/
}

FILES_${PN} += "${prefix}/share/pixmaps"
FILES_${PN} += "${prefix}/share/applications"

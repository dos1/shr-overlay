#class for all the sources under shr project

inherit autotools pkgconfig 

HOMEPAGE = "http://projects.openmoko.org/projects/shr/"
SHR_RELEASE ?= "shr"
SHR_MIRROR ?= "git://shr.bearstech.com/repo"

LICENSE ?= "GPL"

SRC_URI = "${SHR_MIRROR}/shr.git;protocol=http;branch=master"
#SRC_URI := "file://${TOPDIR}/shr/${PN}"
S = "${WORKDIR}/git/${PN}"

FILES_${PN} += "${datadir}/icons"

CVS_TARBALL_STASH =""
GITREV = "r${SRCREV}"
#SVNREV = "${SRCDATE}"

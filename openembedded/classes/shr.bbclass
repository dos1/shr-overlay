#class for all the sources under shr project

def shr_get_s(location):
    return "${WORKDIR}/git/${PN}" if location == "REMOTE" else "${WORKDIR}/${PN}"

def shr_get_src_uri(location):
    return "${SRC_URI_REMOTE}" if location == "REMOTE" else "${SRC_URI_LOCAL}"

def shr_build_srcrev(location, d):
    import bb
    return (("${SHR_PV}+gitr") + ((bb.fetch.get_srcrev(d)) if location == "REMOTE" else ("LOCAL")))

HOMEPAGE = "http://projects.openmoko.org/projects/shr/"
SHR_RELEASE ?= "shr"
SHR_MIRROR ?= "git://shr.bearstech.com/repo"

LICENSE ?= "GPL"
CVS_TARBALL_STASH =""
GITREV = "r${SRCREV}"

SRC_URI_REMOTE = "${SHR_MIRROR}/shr.git;protocol=http;branch=master"
SRC_URI_LOCAL = "file://${TOPDIR}/shr/${PN}"
#Switch to LOCAL and modify SRC_URI_LOCAL to build from local sources
LOCATION_SHR = "REMOTE"

PV = "${@shr_build_srcrev('${LOCATION_SHR}', d)}"
SRC_URI = "${@shr_get_src_uri('${LOCATION_SHR}')}"
S = "${@shr_get_s('${LOCATION_SHR}')}"

FILES_${PN} += "${datadir}/icons"


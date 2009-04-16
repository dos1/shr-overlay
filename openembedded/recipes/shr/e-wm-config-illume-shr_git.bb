DESCRIPTION = "illume SHR config"
SECTION = "e/utils"
DEPENDS = "eet"
LICENSE = "MIT BSD"
PV = "1.0-${EFL_SRCREV}-gitr${SRCREV}"
PR = "r5"

inherit e

SRC_URI = "git://shr.bearstech.com/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/e-wm/${PN}"

EXTRA_OECONF = "\
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
"

FILES_${PN} = "${datadir}/enlightenment/data/config/illume-shr"

RRECOMMENDS_${PN} = "e-wm-theme-illume-shr e-wm-sysactions-shr"


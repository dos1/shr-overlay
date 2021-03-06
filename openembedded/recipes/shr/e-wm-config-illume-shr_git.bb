DESCRIPTION = "illume SHR config"
SECTION = "e/utils"
DEPENDS = "eet"
LICENSE = "MIT BSD"
PV = "1.1-${EFL_SRCREV}-gitr${SRCPV}"
PR = "r6"

inherit e

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/e-wm/${PN}"

EXTRA_OECONF = "\
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
"

FILES_${PN} = "${datadir}/enlightenment/data/config/illume-shr"

RRECOMMENDS_${PN} = "e-wm-theme-illume-shr e-wm-sysactions-shr e-wm-menu-shr"


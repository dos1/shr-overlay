DESCRIPTION = "illume SHR config"
SECTION = "e/utils"
DEPENDS = "eet"
LICENSE = "MIT BSD"
PV = "1.0-${EFL_SRCREV}"
PR = "r2"

inherit e

SRC_URI = "\
  file://configure.ac  \
  file://icon.png     \
  file://module.battery.src     \
  file://module.illume.src  \
  file://module.pager.src\
  file://e.src         \
  file://Makefile.am  \
  file://module.dropshadow.src  \
  file://module.mixer.src   \
  file://profile.desktop"

S = "${WORKDIR}/"

EXTRA_OECONF = "\
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
"

FILES_${PN} = "${datadir}/enlightenment/data/config/illume-shr"

RRECOMMENDS_${PN} = "e-wm-theme-illume-shr"


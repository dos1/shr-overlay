DESCRIPTION = "illume SHR config"
DEPENDS = "eet"
LICENSE = "MIT BSD"
PV = "0.16.999.043+svnr${SRCREV}"
PR = "r19"

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

#RRECOMMENDS_${PN}-config-illume = "${PN}-theme-illume"


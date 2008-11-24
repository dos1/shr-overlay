DESCRIPTION = "SHR Base Applications"
PR = "r2"
PV = "1.0"
LICENSE = "GPL"
inherit task

RDEPENDS_${PN} += "\
  openmoko-icon-theme-standard2 \
  gpe-filemanager \
  vala-terminal \
"

RRECOMMENDS_${PN} += "\
  openmoko-calculator2 \
  tangogps \
  starling \
"

DESCRIPTION = "SHR Base Applications"
PR = "r3"
PV = "1.0"
LICENSE = "GPL"
inherit task

RDEPENDS_${PN} += "\
  openmoko-icon-theme-standard2 \
  gpe-filemanager \
  vala-terminal \
"

RDEPENDS_${PN} += "\
  openmoko-calculator2 \
  tangogps \
  starling \
"

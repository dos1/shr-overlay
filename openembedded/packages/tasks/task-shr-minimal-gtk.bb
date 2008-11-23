DESCRIPTION = "SHR Base Applications"
PR = "r1"
LICENSE = "GPL"
inherit task

RDEPENDS_${PN} = "\
  openmoko-icon-theme-standard2 \
  openmoko-calculator2 \
  vala-terminal \
  tangogps \
  starling \
  gpe-filemanager \
"

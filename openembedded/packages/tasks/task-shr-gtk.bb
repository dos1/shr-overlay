DESCRIPTION = "SHR Base Applications"
PR = "r3"
PV = "1.0"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} += "\
  gpe-scap \
  pidgin \
  vagalume \
  gpe-sketchbook \ 
"

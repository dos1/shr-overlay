DESCRIPTION = "SHR Base Applications"
PR = "r1"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} = "\
  gpe-scap \
  pidgin \
  vagalume \
  gpe-sketchbook \ 
"

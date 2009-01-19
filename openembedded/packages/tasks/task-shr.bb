DESCRIPTION = "SHR Fat Image Feed"
PR = "r0"
PV = "2.0"
LICENSE = "GPL"

inherit task

PACKAGES = "\
  ${PN}-gtk \
  ${PN}-apps \
  ${PN}-games \
"

RDEPENDS_${PN}-gtk = "\
  task-shr-minimal-gtk \
  gpe-scap \
  pidgin \
  vagalume \
  gpe-sketchbook \ 
"

RDEPENDS_${PN}-apps += "\
   task-shr-minimal-apps \
	mofi \
	midori \
"

RDEPENDS_${PN}-games += "\
  numptyphysics \
"


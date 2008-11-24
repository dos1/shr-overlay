DESCRIPTION = "SHR Base Applications"
PR = "r2"
PV = "1.0"
LICENSE = "GPL"

inherit task

RRECOMMENDS_${PN} += "\
  numptyphysics \
"

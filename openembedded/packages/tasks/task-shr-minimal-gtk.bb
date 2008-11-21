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

RDEPENDS_${PN}_append_om-gta01 = "\
  openmoko-alsa-scenarios \
"

RDEPENDS_${PN}_append_om-gta02 = "\
  openmoko-alsa-scenarios \
"


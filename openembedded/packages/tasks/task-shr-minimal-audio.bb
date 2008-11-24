DESCRIPTION = "SHR Base Applications"
PR = "r1"
LICENSE = "GPL"
inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} += "\
  alsa-oss \
  alsa-state \
  alsa-utils-aplay \
  alsa-utils-amixer \
  gst-meta-audio \
  gst-plugin-mad \
  gst-plugin-modplug \
  gst-plugin-sid \
  fso-sounds \
"


RDEPENDS_${PN}_append_om-gta01 =  "\
  openmoko-alsa-scenarios \
"

RDEPENDS_${PN}_append_om-gta02 =  "\
  openmoko-alsa-scenarios \
"



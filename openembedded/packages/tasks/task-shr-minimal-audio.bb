DESCRIPTION = "SHR Base Applications"
PR = "r1"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} = "\
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

DESCRIPTION = "SHR Base Applications"
PR = "r1"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} = "\
  frameworkd \
  fso-gpsd \
  gsm0710muxd \
  python-codecs \
  python-gst \
"

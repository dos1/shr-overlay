DESCRIPTION = "SHR Base Applications"
PR = "r1"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} = "\
#  bash \
  dosfstools \
  htop \
  iptables \
  lsof \
  mickeydbus \
  mickeyterm \
  mtd-utils \
  nano \
  powertop \
  s3c24xx-gpio \
  sysstat \
  tcpdump \
"

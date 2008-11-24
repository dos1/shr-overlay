DESCRIPTION = "SHR Base Applications"
PR = "r2"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} += "\
  netbase \
  sysfsutils \
  modutils-initscripts \
  module-init-tools-depmod \
  rsync \
  screen \
  fbset \
  fbset-modes \
  openssh-sftp-server \
  cron \
  logrotate"
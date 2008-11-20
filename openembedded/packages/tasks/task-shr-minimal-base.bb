DESCRIPTION = "SHR Base Applications"
PR = "r1"
LICENSE = "GPL"

inherit task

RDEPENDS_${PN} = "\
  netbase \
  sysfsutils \
  modutils-initscripts \
  module-init-tools-depmod \
  rsync \
  screen \
  fbset \
  fbset-modes \
  python-elementary \
  glibc-binary-localedata-en-us \
  glibc-binary-localedata-de-de \
  glibc-binary-localedata-fr-fr \
  glibc-binary-localedata-pt-br \
  glibc-binary-localedata-ca-es \
  glibc-binary-localedata-zh-cn \
  glibc-binary-localedata-zh-tw \
  glibc-binary-localedata-bg-bg \
  glibc-binary-localedata-cs-cz \
  glibc-binary-localedata-da-dk \
  glibc-binary-localedata-nl-nl \
  glibc-binary-localedata-fi-fi \
  glibc-binary-localedata-hu-hu \
  glibc-binary-localedata-it-it \
  glibc-binary-localedata-ja-jp \
  glibc-binary-localedata-ko-kr \
  glibc-binary-localedata-nb-no \
  glibc-binary-localedata-pl-pl \
  glibc-binary-localedata-ru-ru \
  glibc-binary-localedata-sk-sk \
  glibc-binary-localedata-sl-si \
  glibc-binary-localedata-es-ar \
  glibc-binary-localedata-sv-se \
"

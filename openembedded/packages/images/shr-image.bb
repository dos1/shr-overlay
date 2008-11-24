require shr-image.inc

DEPENDS += "\
    task-shr-apps \
    task-shr-games \
    task-shr-gtk \
"

IMAGE_INSTALL += "\
  task-shr-apps \
  task-shr-games \
  task-shr-gtk \
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

# perform some SHR convenience tweaks to the rootfs
shr_rootfs_postprocess_append() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}


    #Replace desktop files
    echo "Icon=pidgin.png" >> ./usr/share/applications/pidgin.desktop
    sed -i "s/^X-Icon-path.*$//g" ./usr/share/applications/vagalume.desktop

    cd $curdir
}


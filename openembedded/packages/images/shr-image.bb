require shr-image.inc

#------------------------------------------------------
# SHR Image Recipe
#------------------------------------------------------

GTK_INSTALL += "\
  gpe-scap \
  pidgin \
  vagalume \
  gpe-sketchbook \ 
"

GAMES_INSTALL += "\
  numptyphysics \
"

# SHR
SHR_INSTALL += "\
  midori \
  mofi \
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


#!/bin/sh

git_version=$(git rev-parse --short HEAD)

mv ./android/app/build/outputs/apk/release/app-release-unsigned.apk ./release/revolumote4-release-unsigned_$(date +'%d%m%Y_%H%M%S')_${git_version}.apk

#!/usr/bin/env bash
chmod 777 gradlew &&/
./gradlew clean build &&/
java -jar build/libs/AutoClicker.jar
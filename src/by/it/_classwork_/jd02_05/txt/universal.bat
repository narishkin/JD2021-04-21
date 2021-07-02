set path=D:\students\Khmelov\java-se-8u41-ri\bin
FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ..\res\%%~nI.properties
)
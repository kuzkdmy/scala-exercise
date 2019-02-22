name := "scala-exercise"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  compilerPlugin("com.github.ghik" %% "silencer-plugin" % "1.3.0"),
  "org.typelevel"   %% "cats-core"    % "1.6.0",
  "com.github.ghik" %% "silencer-lib" % "1.3.0" % Provided,
  "org.scalatest"   %% "scalatest"    % "3.0.5" % Test
)
scalacOptions += "-P:silencer:pathFilters=target/.*"
scalacOptions += s"-P:silencer:sourceRoots=${baseDirectory.value.getCanonicalPath}"

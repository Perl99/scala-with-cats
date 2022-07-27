name := "cats-sandbox"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.13.8"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.7.0"

scalacOptions ++= Seq(
  "-target:jvm-1.8",
  "-deprecation", // Warning and location for usages of deprecated APIs.
  "-encoding", "utf-8", // Specify character encoding used by source files.
  "-explaintypes", // Explain type errors in more detail.
  "-feature", // For features that should be imported explicitly.
  "-unchecked", // Generated code depends on assumptions.
  "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
  "-Xlint:adapted-args", // An argument list is modified to match the receiver.
  "-Xlint:constant", // Constant arithmetic expression results in an error.
  "-Xlint:delayedinit-select", // Selecting member of DelayedInit.
  "-Xlint:doc-detached", // A detached Scaladoc comment.
  "-Xlint:inaccessible", // Inaccessible types in method signatures.
  "-Xlint:infer-any", // A type argument is inferred to be `Any`.
  "-Xlint:missing-interpolator", // A string literal appears to be missing an interpolator id.
  "-Xlint:nullary-unit", // Warn when nullary methods return Unit.
  "-Xlint:option-implicit", // Option.apply used implicit view.
  "-Xlint:package-object-classes", // Class or object defined in package object.
  "-Xlint:poly-implicit-overload", // Parameterized overloaded implicit methods are not visible as view bounds.
  "-Xlint:private-shadow", // A private field (or class parameter) shadows a superclass field.
  "-Xlint:stars-align", // Pattern sequence wildcard must align with sequence component.
  "-Xlint:type-parameter-shadow", // A local type parameter shadows a type already in scope.
  "-Ywarn-dead-code", // Warn when dead code is identified.
  "-Ywarn-extra-implicit", // More than one implicit parameter section is defined.
  "-Ywarn-numeric-widen", // Numerics are implicitly widened.
  "-Ywarn-unused:implicits", // An implicit parameter is unused.
  "-Ywarn-unused:imports", // An import selector is not referenced.
  "-Ywarn-unused:locals", // A local definition is unused.
  "-Ywarn-unused:params", // A value parameter is unused.
  "-Ywarn-unused:patvars", // A variable bound in a pattern is unused.
  "-Ywarn-value-discard", // Non-Unit expression results are unused.
  "-Ywarn-unused:privates", // A private member is unused.
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps"
)

scalacOptions --= Seq(
  "-Xlint:nullary-override",
  "-Xfatal-warnings"
)

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.13.2" cross CrossVersion.full)

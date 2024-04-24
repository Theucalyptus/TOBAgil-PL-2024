# ----------------------------------------------------------------
# Script qui génére la doc java du projet
# ----------------------------------------------------------------

src=src/


if [ -d doc ] ; then
    rm -rf doc
fi


for i in `find $src -name "*.java" -print`
do
    javadoc -d doc $i
done

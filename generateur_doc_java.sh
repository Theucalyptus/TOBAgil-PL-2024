# ----------------------------------------------------------------
# Script qui génére la doc java du projet
# ----------------------------------------------------------------

function clean() {
    find -name "*.class" -print -exec rm {} \;
}

if [ -d doc ] ; then
    rm -rf doc
fi

clean
find -name "*.java" -print | grep -v "test" | grep -v "Test" | xargs -r javadoc -d doc
clean
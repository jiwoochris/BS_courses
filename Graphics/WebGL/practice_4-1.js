
var gl;
var points;

window.onload = function init()
{
    var canvas = document.getElementById( "gl-canvas" );

    gl = WebGLUtils.setupWebGL( canvas );
    if ( !gl ) { alert( "WebGL isn't available" ); }

    gl.viewport( 0, 0, canvas.width, canvas.height );
    gl.clearColor( 1.0, 1.0, 1.0, 1.0 );

    //  Load shaders and initialize attribute buffers

    var program = initShaders( gl, "vertex-shader", "fragment-shader" );
    gl.useProgram( program );


    gl.clear( gl.COLOR_BUFFER_BIT );


    for (var i = 0 ; i <50; ++i){
        x = Math.random() * 2 - 1;
        y = Math.random() * 2 - 1;
        // x = Math.random(-1, 1);
        // y = Math.random(-1, 1);
        w = Math.random() * (1-x);
        h = Math.random() * (1-y);

        // Configure WebGL
        var vertices = [
            vec2(x, y),
            vec2(x+w, y),
            vec2(x, y+h),
            vec2(x+w, y+h),
        ]

        // Load the data into the GPU

        var bufferId = gl.createBuffer();
        gl.bindBuffer( gl.ARRAY_BUFFER, bufferId );
        gl.bufferData( gl.ARRAY_BUFFER, flatten(vertices), gl.STATIC_DRAW );

        // Associate vertex data buffer with shader variables

        var vPosition = gl.getAttribLocation( program, "vPosition" );
        gl.vertexAttribPointer( vPosition, 2, gl.FLOAT, false, 0, 0 );
        gl.enableVertexAttribArray( vPosition );

        var colorLoc = gl.getUniformLocation(program , "color");
        gl.uniform4fv(colorLoc, [Math.random(), Math.random(), Math.random(), 1.0]);
        
        gl.drawArrays( gl.TRIANGLE_STRIP, 0, 4);
    }

    

};


function render() {
    gl.clear( gl.COLOR_BUFFER_BIT );
    gl.drawArrays( gl.TRIANGLE_STRIP, 0, 4);
}
